import 'react'
import {useState} from "react";
import AnalysisContainer from "./AnalysisContainer.jsx";

const FileInput = ({setShowAnalysis}) => {

    const analyzeCode = () => {
        setShowAnalysis(true);
    }

    return (
        <div className="file-input">
            <textarea className="textarea textarea-lg textarea-primary" placeholder="Insert your code here"></textarea>
            <button className="btn btn-active btn-primary btn-setting" onClick={analyzeCode}>Analyze</button>
        </div>
    )
}

export default FileInput