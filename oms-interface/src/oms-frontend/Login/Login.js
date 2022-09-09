import React from "react";
import axios from "axios"
import "./LoginForm.css"
import {Link} from "react-router-dom"

class Form extends React.Component {
    constructor(props) {
        super()

        this.state = {
            display: false,
            customerName: '',
            email: '',
            password: ''
        }
    }

    handle = (e) => {
        this.setState({ [e.target.name]: e.target.value })
    }

    handler = (e) => {
        e.preventDefault()
        console.log(this.state)
        axios.post(`http://localhost:8081/customer`, this.state)
            .then(res => {
                console.log(res)
                this.setState({display:true})
            })
            .catch(err => {
                this.setState({display:false})
                console.log(err)
            })
    }

    render() {
        const { customerName, email, password } = this.state
        return (
            <div className="form">
                <div>
                    <h1>SIGN UP</h1>
                </div>
                <div>
                    {this.state.display==true? <label>USER REGISTERED SUCCESSFULLY</label>:null}
                </div>
                <form onSubmit={this.handler}>
                    <label className="label">Name</label>
                    <input onChange={this.handle} className="input" name="customerName"
                        value={customerName} type="text" />

                    <label className="label">Email</label>
                    <input type="email" onChange={this.handle} className="input" name="email"
                        value={email} />

                    <label className="label">Password</label>
                    <input onChange={this.handle} className="input" name="password"
                        value={password} type="password" /><br/>

                    <button className="btn" type="submit">
                        Submit
                    </button><button className="btn"><Link to="/signin">LOGIN</Link></button>
                </form>
            </div>
        )
    }
}

export default Form