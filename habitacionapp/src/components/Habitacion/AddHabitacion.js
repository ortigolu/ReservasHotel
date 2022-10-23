import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { createHabitacion } from "../../actions/habitacionActions";
import classnames from "classnames";

class AddHabitacion extends Component {
  constructor() {
    super();

    this.state = {
      nombreHabitacion: "",
      identificadorHabitacion: "",
      descripcion: "",
      fechaInicio: "",
      fechaFin: "",
      errors: {},
    };

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  //life cycle hooks
  componentWillReceiveProps(nextProps) {
    if (nextProps.errors) {
      this.setState({ errors: nextProps.errors });
    }
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();
    const newHabitacion = {
      nombreHabitacion: this.state.nombreHabitacion,
      identificadorHabitacion: this.state.identificadorHabitacion,
      descripcion: this.state.descripcion,
      fechaInicio: this.state.fechaInicio,
      fechaFin: this.state.fechaFin,
    };

    this.props.createHabitacion(newHabitacion, this.props.history);
  }

  render() {
    const { errors } = this.state;

    return (
      <div>
        {}

        <div className="project">
          <div className="container">
            <div className="row">
              <div className="col-md-8 m-auto">
                <h5 className="display-4 text-center">Reserva de Habitacion</h5>
                <hr />
                <form onSubmit={this.onSubmit}>
                  <div className="form-group">
                    <input
                      type="text"
                      className={classnames("form-control form-control-lg", {
                        "is-invalid": errors.nombreHabitacion,
                      })}
                      placeholder="Nombre De La Habitacion"
                      name="nombreHabitacion"
                      value={this.state.nombreHabitacion}
                      onChange={this.onChange}
                    />
                    {errors.nombreHabitacion && (
                      <div className="invalid-feedback">
                        {errors.nombreHabitacion}
                      </div>
                    )}

                    <br></br>
                  </div>
                  <div className="form-group">
                    <input
                      type="text"
                      className={classnames("form-control form-control-lg", {
                        "is-invalid": errors.identificadorHabitacion,
                      })}
                      placeholder="ID de Habitacion"
                      name="identificadorHabitacion"
                      value={this.state.identificadorHabitacion}
                      onChange={this.onChange}
                    />
                    {errors.identificadorHabitacion && (
                      <div className="invalid-feedback">
                        {errors.identificadorHabitacion}
                      </div>
                    )}

                    <br></br>
                  </div>
                  <div className="form-group">
                    <textarea
                      className={classnames("form-control form-control-lg", {
                        "is-invalid": errors.descripcion,
                      })}
                      placeholder="Observaciones"
                      name="descripcion"
                      value={this.state.descripcion}
                      onChange={this.onChange}
                    />
                    {errors.descripcion && (
                      <div className="invalid-feedback">
                        {errors.descripcion}
                      </div>
                    )}

                    <br></br>
                  </div>
                  <h6>Chech In </h6>
                  <br></br>
                  <div className="form-group">
                    <input
                      type="date"
                      className="form-control form-control-lg"
                      name="fechaInicio"
                      value={this.state.fechaInicio}
                      onChange={this.onChange}
                    />

                    <br></br>
                  </div>
                  <h6>Check Out</h6>
                  <br></br>
                  <div className="form-group">
                    <input
                      type="date"
                      className="form-control form-control-lg"
                      name="fechaFin"
                      value={this.state.fechaFin}
                      onChange={this.onChange}
                    />

                    <br></br>
                  </div>

                  <input
                    type="submit"
                    className="btn btn-primary btn-block mt-4"
                  />
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

AddHabitacion.propTypes = {
  createHabitacion: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired,
};

const mapStateToProps = (state) => ({
  errors: state.errors,
});

export default connect(mapStateToProps, { createHabitacion })(AddHabitacion);
