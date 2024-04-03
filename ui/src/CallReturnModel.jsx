
function convertJSONtoModel(log) {
  const returns = log.returns;

  returns.map(r => {
    r["callTime"] = r.returnNanos - r.duration;
  })

  returns.sort((a, b) => a.callTime - b.callTime);

  const firstStart = returns[0].callTime;

  let openIntervals = []

  returns.forEach(r => {
    openIntervals.forEach((o, index, object) => {
      if (r.callTime >= o) {
        object.splice(index, 1);
      }
    })

    r["layer"] = openIntervals.length;
    openIntervals.push(r.returnNanos)
  })

  returns.map(r => {
    r["returnNanos"] = r["returnNanos"] - firstStart;
    r["callTime"] = r["callTime"] - firstStart;
  })

  return returns;
}

module.exports = convertJSONtoModel;