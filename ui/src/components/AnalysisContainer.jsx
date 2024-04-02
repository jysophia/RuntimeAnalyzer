import 'react'
import FunctionBar from "./FunctionBar.jsx";

const AnalysisContainer = ({data}) => {

  return (
    <div>
      {
        data.map(func =>
          <div className="analysis-container">
            <FunctionBar name={func.name}
                         start={func.start}
                         end={func.end}/>
          </div>)
      }
    </div>
  )
}

export default AnalysisContainer