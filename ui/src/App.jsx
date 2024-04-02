import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
        <div className="mockup-code bg-primary text-primary-content">
            <pre><code>can be any color!</code></pre>
        </div>
    </>
  )
}

export default App
