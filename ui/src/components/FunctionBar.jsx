import 'react'

const FunctionBar = ({name, start, end, next}) => {

  const time = end - start;

  function showModal() {
    document.getElementById(name).showModal()
  }

  function getDuration(f) {
    return f.end - f.start;
  }

  function getNonCallTime() {
    let callTime = 0;
    next.forEach(f => {
      callTime += f.end - f.start;
    })

    return end - start - callTime;
  }

  return (
    <>
      <div className="fn-btn" style={{
        paddingLeft: `calc(${start/4}px)`
      }}>
        <button className="btn btn-secondary"
                onClick={() => showModal()}
                style={{
                  width: `calc(${(end - start)/4}px)`
                }}>
          {name + " (" + time + "ms)"}
        </button>
      </div>
      <dialog id={name} className="modal">
        <div className="modal-box">
          <h3 className="font-bold text-lg">{"Function: " + name + " (" + time + "ms)"}</h3>
          <p className="font-bold py-4">Calls:</p>
          {
            next.map(f =>
              <p className="py-4">{f.name + ": " + getDuration(f) + "ms"}</p>
            )
          }
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