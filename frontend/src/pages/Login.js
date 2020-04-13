import React, { useState, useEffect } from 'react';
import Axios from 'axios';
import { useDispatch } from 'react-redux';
import { withCookies, useCookies } from 'react-cookie';
import { Redirect } from 'react-router-dom';
import { Form, Button, ListGroup } from 'react-bootstrap';
import {Link} from 'react-router-dom'


export default function Login() {

    const [id, setUserid] = useState('aa')
    const [password, setUserpw] = useState('aa')
    const dispatch = useDispatch()
    const [cookies, setCookie, removeCookie] = useCookies(['user'])
    const [hasCookie, setHasCookie] = useState(false);

    const requestLogin = async () => {
        const res = await Axios.post(
            'http://localhost:8080/api/signin',
            { id, password })
        console.log(res)

        if (res.status == 201) {
            dispatch({ type: 'SUCCESS_LOGIN', payload: res.data })
            setCookie('user', res.data)
        }
        console.log(cookies)
    }


    useEffect(() => {
        if (cookies.user && cookies.user !== 'undefined') {
            setHasCookie(true);
        }
    }, [cookies]);


    if (hasCookie) {
        return (
            <div>
                {<Redirect to="/" />}
            </div>
        )
    }


    return (
        <div>
            <a className="logo">Manager</a>
            <ListGroup.Item className="auth">
                <Form>

                    <Form.Group controlId="formBasicEmail">
                        <Form.Label>아이디</Form.Label>
                        <Form.Control type="text" placeholder="아이디를 입력해주세요." value={id} readOnly />
                        <Form.Text className="text-muted">
                        </Form.Text>
                    </Form.Group>

                    <Form.Group controlId="formBasicPassword">
                        <Form.Label>비밀번호</Form.Label>
                        <Form.Control type="password" placeholder="비밀번호를 입력해주세요." value={password} readOnly />
                    </Form.Group>

                    <Button variant="primary" onClick={() => requestLogin()}>
                        로그인
                    </Button>

                    <Link to="/join">
                        <Button variant="warning">
                            회원가입
                         </Button>
                    </Link>

                </Form>
            </ListGroup.Item>

{/* 
            <input type='text' value={id} readOnly></input>
            <input type='text' value={password} readOnly></input>
            <button onClick={() => requestLogin()} >LOGIN</button> */}
        </div >
    )

}