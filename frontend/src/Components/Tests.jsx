import React from 'react';
import UserProfile from './UserProfile';


export class Tests extends React.Component {


    constructor() {
        super();
        if (UserProfile.getId() == null || UserProfile.getId() <= 0) {
            window.location.replace("/login");
        }
        this.state = {
            tests: []
        }
    }


    componentDidMount() {
        const requestOptions = {
            method: 'POST',
            headers: {'accepts': 'application/json'},
        };
        fetch('http://localhost:8080/tests', requestOptions)
            .then(response => response.json())
            .then(data => this.setState({tests: data}));
    }



    render() {
        return (
            <React.Fragment>
                <div>
                    {
                        this.state.tests.map((value, index) => <div key={index}>
                                <h4>Test: {value.name}</h4>
                                <button onClick={event => window.location.replace("/test/"+value.id)}>Start test</button>
                            </div>
                        )
                    }
                </div>
            </React.Fragment>
        )
    }
}

