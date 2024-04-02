import { useState } from 'react'
import './App.css'
import FileInput from "./components/FileInput.jsx";

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
        <FileInput/>
    </>
  )
}

export default App
