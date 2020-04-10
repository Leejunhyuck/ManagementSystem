import React, {useState, useEffect} from 'react'
import Axios from 'axios';


export default function TList(props) {

    const {history, match} = props

    const [page, setPage] = useState(match.params.page)
    const [content,setContent] = useState([])
    console.log(history)

    useEffect(() => {
        const fetchData = async () => {
            const res = await Axios.get("http://localhost:8080/todo/pages/" + page)
            setContent(res.data.content)
        }
        fetchData()
    },[page])


    useEffect(() => {
        console.log("push effect....")
        if(history.action === 'PUSH'){
            history.push("/list/" + page)
        }
    },[page] )

    useEffect(() => {
        if(history.action === 'POP'){
            console.log("pop...Effect...........")
            setPage(match.params.page)
        }
        
    } )

    const list = content.map( ({tno,title} ) => <li key={tno}>{title}</li>  )

    return(
        <div>
            <h1>TodoList Page --- {page} </h1>
            <ul>
                {list}
            </ul>
            <div>
                <button onClick={() => setPage(1) } >1</button>
                <button onClick={() => setPage(2) } >2</button>
                <button onClick={() => setPage(3) } >3</button>
                <button onClick={() => setPage(4) } >4</button>
                <button onClick={() => setPage(5) } >5</button>
            </div>
        </div>
    )
}