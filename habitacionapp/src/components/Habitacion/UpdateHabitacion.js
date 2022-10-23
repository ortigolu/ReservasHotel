import React, { Component } from "react";
import {
  getHabitacion,
  createHabitacion,
} from "../../actions/habitacionActions";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import classnames from "classnames";

class updateHabitacion extends Component {
  //set state
  constructor() {
    super();

    this.state = {
      id: "",
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

  componentWillReceiveProps(nextProps) {
    if (nextProps.errors) {
      this.setState({ errors: nextProps.errors });
    }
    const {
      id,
      habitacionName,
      identificadorHabitacion,
      descripcion,
      fechaInicio,
      fechaFin,
    } = nextProps.habitacion;

    this.setState({
      id,
      habitacionName,
      identificadorHabitacion,
      descripcion,
      fechaInicio,
      fechaFin,
    });
  }

  componentDidMount() {
    const { id } = this.props.match.params;
    this.props.getHabitacion(id, this.props.history);
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();

    const updateHabitacion = {
      id: this.state.id,
      habitacionName: this.state.habitacionName,
      identificadorHabitacion: this.state.identificadorHabitacion,
      descripcion: this.state.descripcion,
      fechaInicio: this.state.fechaInicio,
      fechaFin: this.state.fechaFin,
    };

    this.props.createHabitacion(updateHabitacion, this.props.history);
  }
  render() {
    const { errors } = this.state;
    return (
      <div className="project">
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
              <h5 className="display-4 text-center">
                Actualizar formulario de habitacion
              </h5>
              <hr />
              <form>
                <div className="form-group">
                  <input
                    type="text"
                    className={classnames("form-control form-control-lg", {
                      "is-invalid": errors.nombreHabitacion,
                    })}
                    placeholder="Habitacion Name"
                    name="nombreHabitacion"
                    value={this.state.nombreHabitacion}
                    onChange={this.onChange}
                  />
                  {errors.nombreHabitacion && (
                    <div className="invalid-feedback">
                      {errors.nombreHabitacion}
                    </div>
                  )}
                </div>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg"
                    placeholder="Unique Habitacion ID"
                    name="identificadorHabitacion"
                    value={this.state.identificadorHabitacion}
                    onChange={this.onChange}
                    disabled
                  />
                </div>
                <div className="form-group">
                  <textarea
                    className={classnames("form-control form-control-lg", {
                      "is-invalid": errors.descripcion,
                    })}
                    placeholder="Habitacion descripcion"
                    name="descripcion"
                    onChange={this.onChange}
                    value={this.state.descripcion}
                  />
                  {errors.descripcion && (
                    <div className="invalid-feedback">{errors.descripcion}</div>
                  )}
                </div>
                <h6>Check in</h6>
                <div className="form-group">
                  <input
                    type="date"
                    className="form-control form-control-lg"
                    name="fechaInicio"
                    value={this.state.fechaInicio}
                    onChange={this.onChange}
                  />
                </div>
                <h6>Check out</h6>
                <div className="form-group">
                  <input
                    type="date"
                    className="form-control form-control-lg"
                    name="fechaFin"
                    value={this.state.fechaFin}
                    onChange={this.onChange}
                  />
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
    );
  }
}

updateHabitacion.propTypes = {
  getHabitacion: PropTypes.func.isRequired,
  createHabitacion: PropTypes.func.isRequired,
  habitacion: PropTypes.object.isRequired,
  errors: PropTypes.object.isRequired,
};

const mapStateToProps = (state) => ({
  habitacion: state.habitacion.habitacion,
  errors: state.errors,
});

export default connect(mapStateToProps, { getHabitacion, createHabitacion })(
  updateHabitacion
);
