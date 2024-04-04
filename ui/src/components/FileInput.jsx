import 'react'
import {useEffect, useState} from "react";
import AnalysisContainer from "./AnalysisContainer.jsx";
import test from "./testLog.json";
import JSZip from "jszip";
import * as fs from "fs";

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

async function addProject(userCode) {
    console.log(userCode);

}

function getContent(name){
    return new Promise((resolve, reject) => {
        try {
            const zipString = fs.readFileSync("data/" + name).toString("base64");
            resolve(zipString);
        } catch (ENOENT) {

        }
    });
}

async function handleUpload(event) {
    const zip = new JSZip();
    let promises = [];
    let promiseResult;

    const userCode = getContent(event.target.files[0].name);

    try {
        let zipEntry = await zip.loadAsync(userCode, {base64: true});
        for (const entry of Object.keys(entry.files)) {
            if (!zipEntry.files[entry].dir) {
                if (zipEntry.file(entry) != null) {
                    let fileResult = zipEntry.file(entry).async("text");
                    promises.push(fileResult);
                }
            }
        }
        promiseResult = await Promise.all(promises);
    } catch (e) {
        throw new Error("Couldn't upload zip");
    }

    return promiseResult;
}

const FileInput = ({setShowAnalysis}) => {

    const analyzeCode = (userCode) => {
        setShowAnalysis(true);
        // fetchData();
    }

    return (
        <div className="file-upload">
          <div className="text-btn-container">
              <div>
                  <input type="file" className="file-input w-full max-w-xs" accept=".zip" onChange={handleUpload} />
              </div>
            <div className="btn-container">
              <button className="btn btn-active btn-primary btn-setting" onClick={analyzeCode}>Analyze</button>
            </div>
          </div>
        </div>
    )
}

export default FileInput