const API_BASE = `${import.meta.env.VITE_API_BASE_URL}/orders`;

async function handleResponse(response) {
  if (!response.ok) {
    const error = await response.json().catch(() => ({ message: "Something went wrong" }));
    throw new Error(error.message || `HTTP error ${response.status}`);
  }
  return response.json();
}

export async function getAllOrders() {
  const response = await fetch(API_BASE);
  return handleResponse(response);
}

export async function getOrderById(id) {
  const response = await fetch(`${API_BASE}/${id}`);
  return handleResponse(response);
}

export async function getOrderByNumber(orderNumber) {
  const response = await fetch(`${API_BASE}/number/${orderNumber}`);
  return handleResponse(response);
}

export async function searchOrders(keyword) {
  const response = await fetch(`${API_BASE}/search?keyword=${encodeURIComponent(keyword)}`);
  return handleResponse(response);
}

export async function getOrdersByStatus(status) {
  const response = await fetch(`${API_BASE}/status/${status}`);
  return handleResponse(response);
}
