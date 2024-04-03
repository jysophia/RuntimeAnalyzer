import { useState } from 'react'
import './App.css'
import FileInput from "./components/FileInput.jsx";
import AnalysisContainer from "./components/AnalysisContainer.jsx";

function App() {
    const [showAnalysis, setShowAnalysis] = useState(false)
    const [data, setData] = useState([
        [{
            "key": 0,
            "id": "main0",
            "name": "main",
            "start": 0,
            "end": 4000
        }],
        [{
            "key": 1,
            "id": "testFunc1",
            "name": "testFunc",
            "start": 100,
            "end": 3900
        }],
        [{
            "key": 2,
            "id": "func12",
            "name": "func1",
            "start": 400,
            "end": 1500
        },
        {
            "key": 3,
            "id": "func23",
            "name": "func2",
            "start": 1600,
            "end": 3000
        }],
        [{
            "key": 4,
            "id": "func14",
            "name": "func1",
            "start": 1000,
            "end": 1400
        },
        {
            "key": 5,
            "id": "func25",
            "name": "func2",
            "start": 2200,
            "end": 2900
        }],
        [{
            "key": 6,
            "id": "func36",
            "name": "func3",
            "start": 1100,
            "end": 1400
        },
        {
            "key": 7,
            "id": "func37",
            "name": "func3",
            "start": 2400,
            "end": 2900
        }],
        [{
            "key": 8,
            "id": "func48",
            "name": "func4",
            "start": 2450,
            "end": 2850
        }]
    ])

  return (
    <>
        <h1 className="title">Analyzer</h1>
        {!showAnalysis &&
          <FileInput setShowAnalysis={setShowAnalysis}/>
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
