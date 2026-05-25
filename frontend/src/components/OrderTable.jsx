export default function OrderTable({ orders, onViewOrder }) {
  if (orders.length === 0) {
    return <div className="no-results">No orders found.</div>;
  }

  const getStatusClass = (status) => {
    const map = {
      PENDING: "status-pending",
      CONFIRMED: "status-confirmed",
      PROCESSING: "status-processing",
      SHIPPED: "status-shipped",
      DELIVERED: "status-delivered",
      CANCELLED: "status-cancelled",
    };
    return map[status] || "";
  };

  return (
    <div className="table-container">
      <table className="order-table">
        <thead>
          <tr>
            <th>Order #</th>
            <th>Customer</th>
            <th>Product</th>
            <th>Qty</th>
            <th>Total</th>
            <th>Status</th>
            <th>Order Date</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {orders.map((order) => (
            <tr key={order.id}>
              <td className="order-number">{order.orderNumber}</td>
              <td>{order.customerName}</td>
              <td>{order.product}</td>
              <td>{order.quantity}</td>
              <td className="amount">₹{Number(order.totalAmount).toLocaleString("en-IN")}</td>
              <td>
                <span className={`status-badge ${getStatusClass(order.status)}`}>
                  {order.status}
                </span>
              </td>
              <td>{new Date(order.orderDate).toLocaleDateString("en-IN")}</td>
              <td>
                <button className="btn-view" onClick={() => onViewOrder(order)}>
                  View
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
