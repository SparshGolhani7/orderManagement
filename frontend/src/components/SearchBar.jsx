import { useState } from "react";

export default function SearchBar({ onSearch, onClear }) {
  const [keyword, setKeyword] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (keyword.trim()) {
      onSearch(keyword.trim());
    }
  };

  const handleClear = () => {
    setKeyword("");
    onClear();
  };

  return (
    <form className="search-bar" onSubmit={handleSubmit}>
      <input
        type="text"
        placeholder="Search by order number, customer name, or product..."
        value={keyword}
        onChange={(e) => setKeyword(e.target.value)}
      />
      <button type="submit" className="btn-search">Search</button>
      <button type="button" className="btn-clear" onClick={handleClear}>Clear</button>
    </form>
  );
}
