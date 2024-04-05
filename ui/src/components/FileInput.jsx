import 'react'

function FileInput({setShowAnalysis}) {
    let input = ""
    let argInput = ""

    const parseArgs = (argInput) => {
        let args = []
        let arg = ""
        for (let i = 0; i < argInput.length; i++) {
            if (argInput[i] !== " ") {
                arg += argInput[i];
                if (i === argInput.length - 1) {
                    args.push(arg);
                    arg = "";
                }
            } else {
                args.push(arg);
                arg = "";
            }
        }
        return args;
    }

    const handleArgs = (event) => {
        argInput = event.target.value;
    }

    const handleCode = (event) => {
        input = event.target.value
    }

    const handleUpload = (code, args) => {
        // send to backend?
        console.log(input);
        console.log(args);
    }

    const analyzeCode = () => {
        setShowAnalysis(true);
        let argArray = parseArgs(argInput);
        handleUpload(input, argArray);
    }

    return (
        <div className="file-upload">
          <div className="text-btn-container">
              <div>
                  <input type="text" placeholder="Insert code here" className="input input-bordered input-primary w-full max-w-xs" onChange={handleCode} />
                  <input type="text" placeholder="Insert arguments here" className="input input-bordered input-primary w-full max-w-xs" onChange={handleArgs} />
              </div>
            <div className="btn-container">
              <button className="btn btn-active btn-primary btn-setting" onClick={analyzeCode}>Analyze</button>
            </div>
          </div>
        </div>
    )
}

export default FileInput