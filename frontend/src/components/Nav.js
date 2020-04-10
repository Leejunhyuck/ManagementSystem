import React from 'react'
import {Link} from 'react-router-dom'

export default function Nav() {

    return(
        <div>
            <Link to="/">Main</Link>
            <Link to="/list/1">List</Link>
            <Link to="/register">Register</Link>
            <Link to="/login">Login</Link>
        </div>
    )
}
