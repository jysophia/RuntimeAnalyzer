import 'react'

const FileInput = () => {
    return (
        <div className="file-input">
            <textarea className="textarea textarea-lg textarea-primary" placeholder="Insert your code here"></textarea>
            <button className="btn btn-active btn-primary btn-setting">Generate</button>
        </div>
    )
}

export default FileInput