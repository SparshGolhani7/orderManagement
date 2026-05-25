import { useState, useEffect } from "react";
import SearchBar from "./components/SearchBar";
import StatusFilter from "./components/StatusFilter";
import OrderTable from "./components/OrderTable";
import OrderDetail from "./components/OrderDetail";
import { getAllOrders, searchOrders, getOrdersByStatus } from "./services/orderService";
import "./App.css";

function App() {
  const [orders, setOrders] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [selectedOrder, setSelectedOrder] = useState(null);
  const [activeStatus, setActiveStatus] = useState("ALL");

  useEffect(() => {
    loadAllOrders();
  }, []);

  async function loadAllOrders() {
    setLoading(true);
    setError(null);
    try {
      const data = await getAllOrders();
      setOrders(data);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  }

  async function handleSearch(keyword) {
    setLoading(true);
    setError(null);
    setActiveStatus("ALL");
    try {
      const data = await searchOrders(keyword);
      setOrders(data);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  }

  async function handleFilter(status) {
    setActiveStatus(status);
    setLoading(true);
    setError(null);
    try {
      if (status === "ALL") {
        const data = await getAllOrders();
        setOrders(data);
      } else {
        const data = await getOrdersByStatus(status);
        setOrders(data);
      }
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  }

  return (
    <div className="app">
      <header className="app-header">
        <h1>Order Management Enquiry</h1>
        <p>Search and view order details</p>
      </header>

      <main className="app-main">
        <SearchBar onSearch={handleSearch} onClear={loadAllOrders} />
        <StatusFilter activeStatus={activeStatus} onFilter={handleFilter} />

        {error && <div className="error-message">{error}</div>}
        {loading ? (
          <div className="loading">Loading orders...</div>
        ) : (
          <OrderTable orders={orders} onViewOrder={setSelectedOrder} />
        )}
      </main>

      {selectedOrder && (
        <OrderDetail order={selectedOrder} onClose={() => setSelectedOrder(null)} />
      )}
    </div>
  );
}

export default App;
