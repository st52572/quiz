import React from 'react';


export class Tests extends React.Component {


    constructor() {
        super();
        if (localStorage.getItem("userInfo") == null) {
            this.props.history.push('/login');
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

