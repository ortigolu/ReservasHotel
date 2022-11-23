import React, { Component } from "react";
import { Link } from "react-router-dom";

class Landing extends Component {
  render() {
    return (
      <div className="landing">
        <div className="light-overlay landing-inner text-dark">
          <div className="container">
            <div className="row">
              <div className="col-md-12 text-center">
                <h1 className="display-3 mb-4">
                  Mantenimiento de Reserva de Habitaciones
                </h1>
                <p className="lead">
                  Crear su cuenta para reservar o actualizar una reserva de
                  Habitacion
                </p>
                <hr />
                <Link className="btn btn-lg btn-primary mr-2" to="/register">
                  Registrarse
                </Link>
                <br></br>
                <br></br>
                <Link className="btn btn-lg btn-secondary mr-2" to="/login">
                  Iniciar Sesion
                </Link>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Landing;