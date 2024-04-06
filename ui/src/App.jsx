import { useState } from 'react'
import './App.css'
import FileInput from "./components/FileInput.jsx";
import AnalysisContainer from "./components/AnalysisContainer.jsx";
import convertJSONtoModel from "./CallReturnModel.jsx";


function App() {
  const [showAnalysis, setShowAnalysis] = useState(false)
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
                        <AnalysisContainer fileName={m[0]} data={m[1]} mainParams={m[2]}/>
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
