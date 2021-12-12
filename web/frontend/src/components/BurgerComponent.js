import React from "react";
import DataService from "../services/DataService";

class BurgerComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            data: []
        }
    }

    componentDidMount() {
        DataService.getData().then((response => {
            this.setState({ data: response.data });
        }));
    }

    render() {
        return (
            <div>
                <h1 className="text-center">ImiTálja</h1>

                <table className="table table-striped">
                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>Name</td>
                            <td>Is Vegetarian?</td>
                            <td>Number of patties</td>
                            <td>Price (HUF)</td>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            this.state.data.map(
                                burger =>
                                    <tr key={burger.id}>
                                        <td>{burger.id}</td>
                                        <td>{burger.name}</td>
                                        <td>{burger.vegetarian.toString()}</td>
                                        <td>{burger.numberOfPatties}</td>
                                        <td>{burger.unitPriceInHuf}</td>
                                    </tr>
                            )
                        }
                    </tbody>

                </table>
            </div>
        );
    }
}

export default BurgerComponent