export default function OrderDetail({ order, onClose }) {
  if (!order) return null;

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal-content" onClick={(e) => e.stopPropagation()}>
        <div className="modal-header">
          <h2>Order Details</h2>
          <button className="btn-close" onClick={onClose}>&times;</button>
        </div>
        <div className="modal-body">
          <div className="detail-grid">
            <div className="detail-item">
              <label>Order Number</label>
              <span>{order.orderNumber}</span>
            </div>
            <div className="detail-item">
              <label>Status</label>
              <span className={`status-badge status-${order.status.toLowerCase()}`}>
                {order.status}
              </span>
            </div>
            <div className="detail-item">
              <label>Customer Name</label>
              <span>{order.customerName}</span>
            </div>
            <div className="detail-item">
              <label>Customer Email</label>
              <span>{order.customerEmail}</span>
            </div>
            <div className="detail-item">
              <label>Product</label>
              <span>{order.product}</span>
            </div>
            <div className="detail-item">
              <label>Quantity</label>
              <span>{order.quantity}</span>
            </div>
            <div className="detail-item">
              <label>Unit Price</label>
              <span>₹{Number(order.unitPrice).toLocaleString("en-IN")}</span>
            </div>
            <div className="detail-item">
              <label>Total Amount</label>
              <span className="amount-large">₹{Number(order.totalAmount).toLocaleString("en-IN")}</span>
            </div>
            <div className="detail-item">
              <label>Order Date</label>
              <span>{new Date(order.orderDate).toLocaleString("en-IN")}</span>
            </div>
            <div className="detail-item">
              <label>Delivery Date</label>
              <span>{order.deliveryDate ? new Date(order.deliveryDate).toLocaleString("en-IN") : "—"}</span>
            </div>
            <div className="detail-item full-width">
              <label>Shipping Address</label>
              <span>{order.shippingAddress || "—"}</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
