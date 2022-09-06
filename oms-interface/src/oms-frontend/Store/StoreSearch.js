import React,{ useState,useEffect } from "react"
import axios from "axios"

function Landingpage() {
    const [users, setUsers] = useState({})
    const [id,setId] = useState(1)
    const [idFrom,setIdFrom] = useState(1)

    const handle = () =>{
        setIdFrom(id)
    }
        useEffect(()=>{
            axios.get(`http://localhost:8081/store/${idFrom}`)
            .then((res)=>{
                console.log(res)
                setUsers(res.data)
            })
            .catch((err)=>{
                console.log(err)
            })
        },[idFrom])
    

    return (
        <div>
            <input type="text" value={id} onChange={e => setId(e.target.value)}></input>
            <button onClick={handle}>Search</button>
            <div>
                <h4>{users}</h4>
            </div>
        </div>
    )
}

export default Landingpage;