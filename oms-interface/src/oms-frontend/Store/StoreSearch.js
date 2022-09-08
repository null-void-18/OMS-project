import axios from "axios"
import React, { useState } from "react"
import {Link} from "react-router-dom"
import "./Storesearch.css"

function Storesearch() {
    const [users, setUsers] = useState({})
    const [id, setId] = useState("")

    const handle = () => {
        axios.get(`http://localhost:8081/store/${id}`)
            .then((res) => {
                console.log(res)
                setUsers(res.data)
            })
            .catch((err) => {
                console.log(err)
            })
    }

    return (
        <div>
            <div className="result">
                <b>Enter Store ID</b><input id="input" type="text" value={id} onChange={e => setId(e.target.value)}></input>
                {(id.trim() && !isNaN(+id)) ? <button onClick={handle}>Search</button> : <button disabled>Search</button>}
            </div>
            <div className="tab">
                <table className="table">
                    <thead>
                        <tr>
                            <td scope="col"><strong>Shop Name</strong></td>
                            <td scope="col"><strong>Email Id</strong></td>
                            <td scope="col"><strong>Contact No</strong></td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            (Object.keys(users).length != 0 && users.shopName != null) ?
                            <tr>
                                <td><Link to={`/store/product/${users.id}`}>{users.shopName}</Link></td>
                                <td>{users.emailId}</td>
                                <td>{users.contactNumber}</td>
                            </tr>
                            :
                            ((users.id==0) ?  <td colSpan="3" align="center">Store Not Found</td>:null)
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default Storesearch;