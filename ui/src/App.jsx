import { useState } from 'react'
import './App.css'
import FileInput from "./components/FileInput.jsx";
import AnalysisContainer from "./components/AnalysisContainer.jsx";
import convertJSONtoModel from "./CallReturnModel.jsx";


const log = {"calls":[{"paramNames":["args"],"paramTypes":["String[]"],"paramVals":["NonPrimitiveType"],"methodName":"main","type":"static","objectId":0,"callNanos":51531772787600},{"paramNames":["tpc","val"],"paramTypes":["TestProgramClass","int"],"paramVals":["NonPrimitiveType","15"],"methodName":"printSomething","type":"static","objectId":0,"callNanos":51532589443200},{"paramNames":[],"paramTypes":[],"paramVals":[],"methodName":"getVal","type":"TestProgramClass","objectId":2129789493,"callNanos":51532589525900},{"paramNames":[],"paramTypes":[],"paramVals":[],"methodName":"returnTest","type":"TestProgramClass","objectId":2129789493,"callNanos":51534207049600},{"paramNames":["val"],"paramTypes":["int"],"paramVals":["15"],"methodName":"setVal","type":"TestProgramClass","objectId":2129789493,"callNanos":51535022700500},{"paramNames":[],"paramTypes":[],"paramVals":[],"methodName":"returnTest","type":"TestProgramClass","objectId":2129789493,"callNanos":51535837980900},{"paramNames":[],"paramTypes":[],"paramVals":[],"methodName":"getVal","type":"TestProgramClass","objectId":2129789493,"callNanos":51536652661700}],"returns":[{"duration":801186100,"methodName":"getVal","type":"TestProgramClass","objectId":2129789493,"returnNanos":51533390712000},{"duration":400408300,"methodName":"returnTest","type":"TestProgramClass","objectId":2129789493,"returnNanos":51534607457900},{"duration":615059500,"methodName":"setVal","type":"TestProgramClass","objectId":2129789493,"returnNanos":51535637760000},{"duration":414429000,"methodName":"returnTest","type":"TestProgramClass","objectId":2129789493,"returnNanos":51536252409900},{"duration":800253100,"methodName":"getVal","type":"TestProgramClass","objectId":2129789493,"returnNanos":51537452914800},{"duration":4863858400,"methodName":"printSomething","type":"static","objectId":0,"returnNanos":51537453301600},{"duration":6494259000,"methodName":"main","type":"static","objectId":0,"returnNanos":51538267046600}]};

function App() {
  const [showAnalysis, setShowAnalysis] = useState(false)
  const [data, setData] = useState(convertJSONtoModel(log))
  const [models, setModels] = useState({});

  return (
    <>
      <h1 className="title">Analyzer</h1>
      {!showAnalysis &&
        <FileInput setShowAnalysis={setShowAnalysis} setModels={setModels}/>
      }
      {showAnalysis &&
          <>
            {
              models.map(m =>
                  <>
                    <div className="log-title">{m[0]}</div>
                    <div className="analysis-outer-container">
                      <div className="analysis-wrapper">
                        <AnalysisContainer data={m[1]}/>
                      </div>
                    </div>
                  </>
              )
            }
          </>
      }
    </>
  )
}

export default App
