import 'react'

const FunctionBar = ({name, start, end}) => {

  const time = end - start;

  return (
    <div className="fn-btn" style={{
      paddingLeft: `calc(${start/4}px)`
    }}>
      <button className="btn btn-secondary" style={{
        width: `calc(${(end - start)/4}px)`
      }}>{name + " (" + time + "ms)"}</button>
    </div>
  )
}

export default FunctionBar