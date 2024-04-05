
function convertJSONtoModel(log) {
  const returns = log.returns;

  returns.map(r => {
    r["callTime"] = r.returnNanos - r.duration;
  })

  returns.sort((a, b) => a.callTime - b.callTime);

  const firstStart = returns[0].callTime;

  let openIntervals = []

  returns.forEach(r => {
    let temp = []
    openIntervals.forEach((o, index, object) => {
      if (r.callTime < o) {
        temp.push(o);
      }
    })

    openIntervals = temp;

    r["layer"] = openIntervals.length;
    openIntervals.push(r.returnNanos)
  })

  returns.map(r => {
    r["returnNanos"] = r["returnNanos"] - firstStart;
    r["callTime"] = r["callTime"] - firstStart;
  })

  returns.sort((a, b) => a.layer - b.layer);

  let model = [];
  let layer = 0;

  let curr = [];
  let key = 0;

  returns.forEach(r => {
    let transformed = {}
    transformed["key"] = key;
    key++;

    transformed["name"] = r.methodName;
    transformed["id"] = r.methodName + key.toString();

    // Convert to ms
    transformed["start"] = r.callTime / 1000000;
    transformed["end"] = r.returnNanos / 1000000;

    if (r.layer === layer) {
      curr.push(transformed);
    } else {
      model.push(curr);
      curr = [];
      layer++;
      curr.push(transformed);
    }
  })

  model.push(curr)

  return model;
}

export default convertJSONtoModel;