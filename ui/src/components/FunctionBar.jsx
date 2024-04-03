import 'react'
import {useEffect, useState} from "react";

const FunctionBar = ({id, name, start, end, pad, next}) => {

  const time = end - start;
  const [subCalls, setSubCalls] = useState(next.filter((n) => n.start >= start && n.end <= end));

  function showModal() {
    document.getElementById(id).showModal()
  }

  function getDuration(f) {
    return f.end - f.start;
  }

  function getNonCallTime() {
    let callTime = 0;
    subCalls.forEach(f => {
      callTime += f.end - f.start;
    })

    return end - start - callTime;
  }

  return (
    <>
      <div className="fn-btn" style={{
        paddingLeft: `calc(${pad/4}px)`
      }}>
        <button className="btn btn-accent"
                onClick={() => showModal()}
                style={{
                  width: `calc(${(end - start)/4}px)`
                }}>
          {name + " (" + time + "ms)"}
        </button>
      </div>
      <dialog id={id} className="modal">
        <div className="modal-box">
          <h3 className="font-bold text-lg">{"Function: " + name + " (" + time + "ms)"}</h3>
          <hr width="100%" style={{color: 'black', height: '10px'}} />
          <p className="font-bold py-4">Calls:</p>
          {
            subCalls.map(f =>
              <p className="py-4">{f.name + "(): " + getDuration(f) + "ms"}</p>
            )
          }
          <hr width="100%" color="black" size="50px" />
          <p className="font-bold py-4">{"Non call time: " + getNonCallTime()}</p>
        </div>
        <form method="dialog" className="modal-backdrop">
          <button>close</button>
        </form>
      </dialog>
    </>
  )
}

export default FunctionBar