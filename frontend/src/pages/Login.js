import React, {useState} from 'react'
import Axios from 'axios';
import {useDispatch} from 'react-redux'
import { withCookies, useCookies } from 'react-cookie';
import {Redirect} from 'react-router-dom'


export default function Login() {

    const [id,setUserid] = useState('aa')
    const [password,setUserpw] = useState('aa')
    const dispatch = useDispatch()
    const [ cookies, removeCookie ] = useCookies([ 'user' ]);
    const [ hasCookie, setHasCookie ] = useState(false);

    const requestLogin = async () => {
        const res = await Axios.post(
            'http://localhost:8080/api/signin',
            {id,password})
        console.log(res)
        dispatch({type:'SUCCESS_LOGIN', payload:res.data})

    }

    return(
        

        <div>
            {!hasCookie ? <Redirect to="/login" /> : <Redirect to="/todo" />}
            <input type='text' value={id} readOnly></input>
            <input type='text' value={password} readOnly></input>
            <button onClick={()  => requestLogin() } >LOGIN</button>
        </div>
    )

}