import 'react'
import FunctionBar from "./FunctionBar.jsx";

const AnalysisContainer = ({data, fileName}) => {

  const scaleFactor = (data[0][0].end - data[0][0].start) / 1200

  function getNext(index) {
    if (index < data.length - 1) {
      return data[index + 1]
    } else {
      return [{"name": "No functions", "start": 0, "end": 0}]
    }
  }

  function getPad(group, index) {
    if (index > 0) {
      return group[index].start - group[index - 1].end
    } else {
      return group[index].start
    }
  }

  return (
    <div>
      <div className="bar-wrapper">
        {
          data.map((group, index) =>
            <div className="bar-container">
              {
                group.map((func, i) =>
                  <FunctionBar func={func}
                               pad={getPad(group, i)}
                               next={getNext(index)}
                               scaleFactor={scaleFactor}
                               fileName={fileName}/>
                )
              }
            </div>
          )
        }
      </div>
    </div>
  )
}

export default AnalysisContainer