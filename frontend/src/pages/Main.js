import React from 'react'
import {useSelector} from 'react-redux'

export default function Main(props) {

    const user = useSelector( state => state.memberReducer.user)

    console.log(user)

    return(
        <div>
            <h1>Main Page</h1>
            {user.name ? <h2>{user.name} 님 반갑습니다 </h2>:<h3>GUEST</h3>}
            
        </div>
    )
}