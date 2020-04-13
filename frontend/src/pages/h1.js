import React from 'react';
import { Row, Container, Col } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import './h1.css';
import LoginInput from './Login';



export default function h1() {
    return (
        <div>
            <Container>
                <Row>
                    <Col></Col>
                    <Col xs={5}><LoginInput></LoginInput></Col>
                    <Col></Col>
                </Row>
            </Container>
        </div>
    )
}