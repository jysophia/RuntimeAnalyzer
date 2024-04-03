import 'react'
import {useEffect, useState} from "react";
import AnalysisContainer from "./AnalysisContainer.jsx";
import test from "./testLog.json";

function fetchData() {
    fetch('../../../parsedcode/log/log.json', {
        method: 'GET'
    })
        .then(response => response.text())
        .then(data => {
            let result = JSON.parse(data);
            console.log(result);
        })
        .catch(err => console.log('Error found: ' + err));
}

const FileInput = ({setShowAnalysis}) => {

    const analyzeCode = () => {
        setShowAnalysis(true);
        fetchData();
    }

    return (
        <div className="file-input">
          <div className="text-btn-container">
            <textarea className="textarea textarea-lg textarea-primary" placeholder="Insert your code here"></textarea>
            <div className="btn-container">
              <button className="btn btn-active btn-primary btn-setting" onClick={analyzeCode}>Analyze</button>
            </div>
          </div>
        </div>
    )
}

export default FileInput