import 'react'
import FunctionBar from "./FunctionBar.jsx";

const AnalysisContainer = ({data}) => {

  function getWork(index) {
    if (index < data.length - 1) {
      return data[index + 1]
    } else {
      return [{"name": "No functions"}]
    }
  }

  return (
    <div>
      <div>
        {
          data.map((group, index) =>
            <div className="analysis-container" style={{

            }}>
              {
                group.map(func =>
                  <FunctionBar name={func.name}
                               start={func.start}
                               end={func.end}
                               next={getWork(index)}/>
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