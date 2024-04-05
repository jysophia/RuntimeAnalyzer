import 'react'
import {useEffect, useState} from "react";

const FunctionBar = ({func, pad, next, scaleFactor, fileName}) => {

  const time = roundTo2(func.end - func.start);
  const [subCalls, setSubCalls] = useState(next.filter((n) => n.start >= func.start && n.end <= func.end));

  function roundTo2(num) {
    return Math.round(num * 100) / 100;
  }

  function showModal() {
    document.getElementById(func.id + fileName).showModal()
  }

  function getDuration(f) {
    return roundTo2(f.end - f.start);
  }

  function getNonCallTime() {
    let callTime = 0;
    subCalls.forEach(f => {
      callTime += f.end - f.start;
    })

    return func.end - func.start - callTime;
  }

  return (
    <>
      <div className="fn-btn" style={{
        paddingLeft: `calc(${pad/scaleFactor}px)`
      }}>
        <button className="btn btn-accent"
                onClick={() => showModal()}
                style={{
                  width: `calc(${roundTo2((func.end - func.start)/scaleFactor)}px)`
                }}>
          {func.name + " (" + time + "ms)"}
        </button>
      </div>
      <dialog id={func.id + fileName} className="modal">
        <div className="modal-box">
          <h3 className="font-bold text-lg">{"Function: " + func.name + " (" + time + "ms)"}</h3>
          <hr width="100%" style={{color: 'black', height: '10px'}} />
          <p className="font-bold py-4">Args:</p>
          {
            func.paramNames.map((pn, index) =>
              <p className="py-4">{pn + " = " + func.paramVals[index]}</p>
            )
          }
          <p className="font-bold py-4">Calls:</p>
          {
            subCalls.map(f =>
              <p className="py-4">{f.name + "(): " + getDuration(f) + "ms"}</p>
            )
          }
          <hr width="100%" color="black" size="50px" />
          <p className="font-bold py-4">{"Non call time: " + roundTo2(getNonCallTime()) + "ms"}</p>
        </div>
        <form method="dialog" className="modal-backdrop">
          <button>close</button>
        </form>
      </dialog>
    </>
  )
}

export default FunctionBar