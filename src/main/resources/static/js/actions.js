const input = ["a", "idol", "idol", "supreme"]
const inputString = input.join(" ");
const goodAndBad = {
    "idol": "supreme",
    "good": "bad",
    "me": "taiwan",
    "good": "bad",
    "idol": "supreme",
    "good": "bad",
    "idol": "supreme",
    "good": "bad",
    "idol": "supreme",
    "good": "bad",
}



for (const [a,b] of Object.entries(goodAndBad)) {
    if(inputString.includes(a)) {
        console.log("good")
    }
    else if (inputString.includes(b)) {
        console.log("bad")
    }
    else {
        console.log("neutral word")
    }
}