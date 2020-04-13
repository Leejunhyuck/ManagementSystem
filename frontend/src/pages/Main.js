import React, { useState,useEffect } from 'react'
import {useSelector} from 'react-redux'
import { withCookies, useCookies } from 'react-cookie';

export default function Main(props) {

    //const user = useSelector( state => state.memberReducer.user)
    //console.log(user)
    const [cookies, setCookie, removeCookie] = useCookies(['user']);
    console.log(cookies)
    const [hasCookie, setHasCookie] = useState(false);

    useEffect(() => {
        if(cookies.user && cookies.user !== "undefined"){
            setHasCookie(true)
        }
    },[cookies])

    // return(
    //     <div>
    //         <h1>Main Page</h1>
    //         {user.name ? <h2>{user.name} 님 반갑습니다 </h2>:<h3>GUEST</h3>}
            
    //     </div>
    // )

    return(
        <div>
            <h1>Main Page</h1>
            {hasCookie? <h2>{cookies.user.name} 님 반갑습니다 </h2>:<h3>GUEST</h3>}
            
        </div>
    )
}