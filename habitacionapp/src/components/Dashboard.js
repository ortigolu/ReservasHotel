import React, { Component } from "react";
import CreateHabitacionButton from "./Habitacion/CreateHabitacionButton";
import HabitacionItem from "./Habitacion/HabitacionItem";

class Dashboard extends Component {
  render() {
    return (
      <div>
        <div className="projects">
          <div className="container">
            <div className="row">
              <div className="col-md-12">
                <h1 className="display-4 text-center">Habitaciones</h1>
                <br />
                <CreateHabitacionButton />

                <br />
                <hr />
                <HabitacionItem />
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
export default Dashboard;
