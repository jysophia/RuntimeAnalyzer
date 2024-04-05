import React, {useEffect, useState} from 'react'
import convertJSONtoModel from "../CallReturnModel.jsx";

function FileInput({setShowAnalysis, setModels}) {
    const [newLines, setNewLines] = useState([]);
    const [files, setFiles] = useState([]);
    let fileReader;

    const addAnotherFile = () => {
        setNewLines([...newLines, newLines.length]);
    }

    const handleUpload = (event) => {
        let file = event.target.files[0];
        if (file) {
            fileReader = new FileReader();
            fileReader.onloadend = function() {
                const content = fileReader.result;
                setFiles([...files, [file.name, content]]);
            }
            fileReader.readAsText(file);
        }
    }

    useEffect(() => {
        // if (files.length) {
        //     console.log(files[0])
        // }
    }, [files]);

    const analyzeCode = (event) => {
        setShowAnalysis(true);
        let models = [];

        files.forEach(f => {
            models.push([f[0], convertJSONtoModel(JSON.parse(f[1]))]);
        });

        console.log(models)

        setModels(models);
    }

    return (
        <div className="file-upload">
          <div className="text-btn-container">
              <div className="file-upload-container">
                  <button className="btn btn-active btn-primary btn-add-setting" onClick={addAnotherFile}>Add Another JSON</button>
                  <div className="file-input-container">
                      <input type="file" className="file-input w-full max-w-xs" onChange={handleUpload} />
                  </div>
                  {
                      newLines.map(() => (
                          <div className="file-input-container">
                              <input type="file" className="file-input w-full max-w-xs" onChange={handleUpload} />
                          </div>
                      ))
                  }
              </div>
            <div className="btn-container">
              <button className="btn btn-active btn-primary btn-setting" onClick={analyzeCode}>Analyze</button>
            </div>
          </div>
        </div>
    )
}

export default FileInput