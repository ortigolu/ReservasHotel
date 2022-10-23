import React, { Component } from "react";
import { Link } from "react-router-dom";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { deleteHabitacion } from "../../actions/habitacionActions";

class HabitacionItem extends Component {
  onDeleteClick = (id) => {
    this.props.deleteHabitacion(id);
  };

  render() {
    const { habitacion } = this.props;
    return (
      <div className="container">
        <div className="card card-body bg-light mb-3">
          <div className="row">
            <div className="col-2">
              <span className="mx-auto">
                {habitacion.indentificadorHabitacion}
              </span>
            </div>
            <div className="col-lg-6 col-md-4 col-8">
              <h3>{habitacion.nombreHabitacion}</h3>
              <p>{habitacion.descripcion}</p>
            </div>
            <div className="col-md-4 d-none d-lg-block">
              <ul className="list-group">
                <a href="#">
                  <li className="list-group-item board">
                    <i className="fa fa-flag-checkered pr-1">
                      {" "}
                      Board de Habitacion{" "}
                    </i>
                  </li>
                </a>
                <Link
                  to={`/updateHabitacion/${habitacion.indentificadorHabitacion}`}
                >
                  <li className="list-group-item update">
                    <i className="fa fa-edit pr-1">
                      {" "}
                      Actualizar Informacion de Habitacion
                    </i>
                  </li>
                </Link>

                <li
                  className="list-group-item delete"
                  onClick={this.onDeleteClick.bind(
                    this,
                    habitacion.identificadorHabitacion
                  )}
                >
                  <i className="fa fa-minus-circle pr-1">
                    {" "}
                    Eliminar Reserva de Habitacion
                  </i>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
HabitacionItem.propTypes = {
  deleteHabitacion: PropTypes.func.isRequired,
};

export default connect(null, { deleteHabitacion })(HabitacionItem);
