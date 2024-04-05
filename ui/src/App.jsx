import { useState } from 'react'
import './App.css'
import FileInput from "./components/FileInput.jsx";
import AnalysisContainer from "./components/AnalysisContainer.jsx";
import convertJSONtoModel from "./CallReturnModel.jsx";


const log = {"calls":[{"methodName":"printSomething","type":"static","objectId":0,"callNanos":656481108010},{"methodName":"getVal","type":"TestProgramClass","objectId":1555009629,"callNanos":656481716973},{"methodName":"returnTest","type":"TestProgramClass","objectId":1555009629,"callNanos":656491004942},{"methodName":"setVal","type":"TestProgramClass","objectId":1555009629,"callNanos":656491016948},{"methodName":"returnTest","type":"TestProgramClass","objectId":1555009629,"callNanos":656491020166},{"methodName":"getVal","type":"TestProgramClass","objectId":1555009629,"callNanos":656491023303}],"returns":[{"duration":2614,"methodName":"getVal","type":"TestProgramClass","objectId":1555009629,"returnNanos":656481719587},{"duration":4867,"methodName":"returnTest","type":"TestProgramClass","objectId":1555009629,"returnNanos":656491009809},{"duration":1569,"methodName":"setVal","type":"TestProgramClass","objectId":1555009629,"returnNanos":656491018517},{"duration":1468,"methodName":"returnTest","type":"TestProgramClass","objectId":1555009629,"returnNanos":656491021634},{"duration":1086,"methodName":"getVal","type":"TestProgramClass","objectId":1555009629,"returnNanos":656491024389},{"duration":10409385,"methodName":"printSomething","type":"static","objectId":0,"returnNanos":656491517395}]};

function App() {
    const [showAnalysis, setShowAnalysis] = useState(false)
    const [data, setData] = useState(convertJSONtoModel(log))
    const [files, setFiles] = useState([]);

  return (
    <>
        <h1 className="title">Analyzer</h1>
        {!showAnalysis &&
          <FileInput setShowAnalysis={setShowAnalysis} files={files} setFiles={setFiles}/>
        }
        <div className="analysis-outer-container">
            {showAnalysis &&
                <div className="analysis-wrapper">
                    <AnalysisContainer data={data}/>
                </div>
            }
        </div>
    </>
  )
}

export default App
