import { useState } from 'react'
import './App.css'
import FileInput from "./components/FileInput.jsx";
import AnalysisContainer from "./components/AnalysisContainer.jsx";

function App() {
  const [count, setCount] = useState(0)

  const [data, setData] = useState([
    {
      "key": 0,
      "name": "main",
      "start": 0,
      "end": 4000
    },
    {
      "key": 1,
      "name": "testFunc",
      "start": 100,
      "end": 3900
    },
    {
      "key": 2,
      "name": "func1",
      "start": 400,
      "end": 1000
    },
    {
      "key": 3,
      "name": "func2",
      "start": 1100,
      "end": 1900
    }
  ])

  return (
    <>
        <FileInput/>
        <div className="analysis-wrapper">
          <AnalysisContainer data={data}/>
        </div>
    </>
  )
}

export default App
