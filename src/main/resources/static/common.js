// Backend address. Swagger shows "/Library".
// If your context-path in application.properties is different (e.g. /Literature), change it here.
const API = "http://localhost:8080/Library";

const $ = (id) => document.getElementById(id);

// Safe way to put text into HTML
const esc = (s) =>
  String(s ?? "").replace(/[&<>"']/g, (c) => ({ "&": "&amp;", "<": "&lt;", ">": "&gt;", '"': "&quot;", "'": "&#39;" }[c]));

const fullName = (a) => (a ? `${a.name ?? ""} ${a.surname ?? ""}`.trim() || "—" : "—");

async function api(path, opts = {}) {
  const res = await fetch(API + path, { headers: { "Content-Type": "application/json" }, ...opts });
  const text = await res.text();
  let data = null;
  try {
    data = text ? JSON.parse(text) : null;
  } catch {
    data = text;
  }
  if (!res.ok) {
    const msg = data && typeof data === "object" ? Object.values(data).join(", ") : data || "Error: " + res.status;
    throw new Error(msg);
  }
  return data;
}

function toast(msg, bad = false) {
  let t = $("toast");
  if (!t) {
    t = document.createElement("div");
    t.id = "toast";
    document.body.appendChild(t);
  }
  t.textContent = msg;
  t.className = "show" + (bad ? " bad" : "");
  clearTimeout(toast.timer);
  toast.timer = setTimeout(() => (t.className = ""), 3500);
}
