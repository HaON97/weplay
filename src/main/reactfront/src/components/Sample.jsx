import React, { Component } from 'react';
import SampleService from '../service/SampleService';

class Sample extends Component {
    constructor(props){
        super(props)

        this.state = {
            data: ""
        }
    }

    componentDidMount(){
        SampleService.getList().then((res) => {
            this.setState({datas: res.data});
            console.log(res.data);
        })
    }

    render() {
        return (
            <div>
            </div>
        );
    }
}

export default Sample;