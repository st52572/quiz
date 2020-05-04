import React from 'react';
export class Input extends React.Component {

    handleChange = (event) => {
        let index = 0;
        if(this.props.index){
            index = this.props.index;
        }
        this.props.onChange({index: index, text: event.target.value})
    };

    render() {
        return (
            <React.Fragment>
                <label>{this.props.text}</label>
                <input type={this.props.type} onChange={this.handleChange} value={this.props.value} />
            </React.Fragment>
        )
    }


}