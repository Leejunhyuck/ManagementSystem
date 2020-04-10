import React, {useRef, useState} from 'react'
import Axios from 'axios';
import {Redirect} from 'react-router-dom'

export default function TRegister(props) {

    const input = useRef(null)
    const [result,setResult] = useState(0)

    const requestRegist = () => {
        const title = input.current.value
        console.log(title)
        Axios.post("http://192.168.41.80:8080/todo/new", {title:title})
        .then( res => {
            console.log(res.status)
            setResult(res.status)
        })
    }

    console.log("--------------------------------")

    return(
        <div>
            {result === 200 ? 
                <Redirect to="/list/1"></Redirect>
              :
                <div>
                    <input type='text' ref={input}></input>
                    <button onClick={() => requestRegist()} >Register</button>
                </div>
            }
            
        </div>
    )
}