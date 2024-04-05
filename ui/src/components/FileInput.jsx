import React, {useState} from 'react'

function FileInput({setShowAnalysis}) {
    const [files, setFiles] = useState([]);
    const [newLines, setNewLines] = useState([]);

    const addAnotherFile = () => {
        setNewLines([...newLines, newLines.length]);
    }

    const handleUpload = (event) => {
        setFiles([...files, event.target.files[0]]);
    }

    const analyzeCode = (event) => {
        setShowAnalysis(true);
    }

    return (
        <div className="file-upload">
          <div className="text-btn-container">
              <div className="file-upload-container">
                  <input type="file" className="file-input w-full max-w-xs" onChange={handleUpload} />
                  <button className="btn btn-active btn-primary btn-add-setting" onClick={addAnotherFile}>+</button>
              </div>
              {
                  newLines.map(() => (
                      <input type="file" className="file-input w-full max-w-xs" onChange={handleUpload} />
                  ))
              }
            <div className="btn-container">
              <button className="btn btn-active btn-primary btn-setting" onClick={analyzeCode}>Analyze</button>
            </div>
          </div>
        </div>
    )
}

export default FileInput