import React, { Component } from "react";
import CreateHabitacionButton from "./Habitacion/CreateHabitacionButton";
import HabitacionItem from "./Habitacion/HabitacionItem";
import { connect } from "react-redux";
import { getHabitaciones } from "../actions/habitacionActions";
import PropTypes from "prop-types";

class Dashboard extends Component {
  componentDidMount() {
    this.props.getHabitaciones();
  }

  render() {
    const { habitaciones } = this.props.habitacion;

    return (
      <div>
        <div className="habitaciones">
          <div className="container">
            <div className="row">
              <div className="col-md-12">
                <h1 className="display-4 text-center">Habitaciones</h1>
                <br />
                <CreateHabitacionButton />

                <br />
                <hr />
                {habitaciones.map((habitacion) => (
                  <HabitacionItem key={habitacion.id} habitacion={habitacion} />
                ))}
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
Dashboard.propTypes = {
  habitacion: PropTypes.object.isRequired,
  getHabitaciones: PropTypes.func.isRequired,
};
const mapStateToProps = (state) => ({
  habitacion: state.habitacion,
});
export default connect(mapStateToProps, { getHabitaciones })(Dashboard);
