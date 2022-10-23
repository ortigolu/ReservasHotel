import "./App.css";
import Dashboard from "./components/Dashboard";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Header from "./components/Layout/Header";
import AddHabitacion from "./components/Habitacion/AddHabitacion";

function App() {
  return (
    <Router>
      <div className="App">
        <Header />
        <Routes>
          <Route exact path="/dashboard" element={<Dashboard />} />
          <Route exact path="/addHabitacion" element={<AddHabitacion />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
