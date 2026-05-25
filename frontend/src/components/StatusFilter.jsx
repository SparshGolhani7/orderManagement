const statuses = ["ALL", "PENDING", "CONFIRMED", "PROCESSING", "SHIPPED", "DELIVERED", "CANCELLED"];

export default function StatusFilter({ activeStatus, onFilter }) {
  return (
    <div className="status-filter">
      {statuses.map((status) => (
        <button
          key={status}
          className={`filter-btn ${activeStatus === status ? "active" : ""}`}
          onClick={() => onFilter(status)}
        >
          {status}
        </button>
      ))}
    </div>
  );
}
